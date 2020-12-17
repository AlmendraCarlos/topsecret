package com.meli.topSecret.service;

import com.meli.topSecret.domain.Satellites;
import com.meli.topSecret.dto.responseUltraSecretDTO.positionDTO;
import com.meli.topSecret.dto.responseUltraSecretDTO.responseTopUltraSecretDTO;
import com.meli.topSecret.dto.satellitesDTO;
import com.meli.topSecret.dto.secretDTO;
import com.meli.topSecret.repository.SatellitesRepository;
import com.meli.topSecret.trilaterationEngine.Point;
import com.meli.topSecret.trilaterationEngine.Trilateration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class secretService {

    private final SatellitesRepository satellitesRepository;

    private double[] getLocation(){

        List<Satellites> satellites = satellitesRepository.findAll();

        Point p1 = new Point(satellites.get(0).getPos_x(), satellites.get(0).getPos_y(), satellites.get(0).getDistance());
        Point p2 = new Point(satellites.get(1).getPos_x(), satellites.get(1).getPos_y(), satellites.get(1).getDistance());
        Point p3 = new Point(satellites.get(2).getPos_x(), satellites.get(2).getPos_y(), satellites.get(2).getDistance());

        double[] position = Trilateration.Compute(p1,p2,p3);

        return position;

    }


    private String getMessage(){

        List<Satellites> satellites = satellitesRepository.findAll();

        List<String> msg1 = satellites.get(0).getMessage();
        List<String> msg2 = satellites.get(1).getMessage();
        List<String> msg3 = satellites.get(2).getMessage();

        for(int i = 0; i< msg1.size(); i++ ){
            if(!msg2.get(i).equals("")){
                msg1.set(i, msg2.get(i));
            }
            if(!msg3.get(i).equals("")){
                msg1.set(i, msg3.get(i));
            }
        }

        return msg1.stream().map(Objects::toString).collect(Collectors.joining(" "));

    }


    public responseTopUltraSecretDTO decodeUltraSecret(final secretDTO data){

        persistData(data);
        return getInfo();

    }

    public void topSecretSplit(final secretDTO data){
        persistData(data);
    }

    public responseTopUltraSecretDTO getInfo(){

        responseTopUltraSecretDTO responseTopUltraSecretDTO = new responseTopUltraSecretDTO();
        positionDTO positionDTO = new positionDTO();

        double[] positionCalculate = getLocation();

        positionDTO.setX(positionCalculate[0]);
        positionDTO.setY(positionCalculate[1]);

        responseTopUltraSecretDTO.setMessage(getMessage());
        responseTopUltraSecretDTO.setPosition(positionDTO);

        return responseTopUltraSecretDTO;
    }


    private void persistData(final secretDTO data){
        for(satellitesDTO s : data.getSatellites()) {
            Satellites satellites1 = satellitesRepository.findByName(s.getName());
            satellites1.setDistance(s.getDistance());
            satellites1.setMessage(s.getMessage());
            satellitesRepository.save(satellites1);
        }
    }

}
