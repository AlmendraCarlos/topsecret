package com.meli.topSecret.controller;

import com.meli.topSecret.dto.satellitesDTO;
import com.meli.topSecret.dto.secretDTO;
import com.meli.topSecret.service.secretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class controller {

    @Autowired
    private secretService secretService;

    @PostMapping("topsecret")
    public ResponseEntity responseSatellite(@RequestBody final secretDTO satellites) {

        try{
            return ResponseEntity.ok(secretService.decodeUltraSecret(satellites));
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("topsecret_split/{satellite_name}")
    public ResponseEntity responseSatelliteSplit(@PathVariable("satellite_name") final String satellite_name, @RequestBody final satellitesDTO satellitesDTO) {

        try{
            secretService.topSecretSplit(getFormat(satellite_name, satellitesDTO));
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("topsecret_split")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity responseSatelliteSplitGet() {

        try{
            return ResponseEntity.ok(secretService.getInfo());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No hay suficiente informacion");
        }
    }

    private secretDTO getFormat(final String satellite_name, final satellitesDTO satellitesDTO){

        secretDTO sat = new secretDTO();
        satellitesDTO.setName(satellite_name);
        List<satellitesDTO> satellitesDTOList = new ArrayList<>();
        satellitesDTOList.add(satellitesDTO);
        sat.setSatellites(satellitesDTOList);
        return sat;

    }

}
