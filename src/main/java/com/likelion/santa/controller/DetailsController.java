package com.likelion.santa.controller;

import com.likelion.santa.dto.DetailsDto;
import com.likelion.santa.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080",allowedHeaders = "*")@RestController
@RequestMapping("/details/{board_id}")
public class DetailsController {

    @Autowired
    DetailsService detailsService;

    @PostMapping
    public ResponseEntity<String> post(@PathVariable Long board_id, @RequestBody DetailsDto detailsDto){
        try{
            detailsService.write(board_id, detailsDto);
            return ResponseEntity.ok("상세정보 등록 성공");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{details_id}")
    public ResponseEntity<String> delete(@PathVariable Long details_id){
        try{
            detailsService.deleteDetails(details_id);
            return ResponseEntity.ok("상세정보 삭제 성공");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{details_id}")
    public ResponseEntity<String> update(@PathVariable Long details_id, @RequestBody DetailsDto detailsDto){
        try{
            detailsService.updateDetails(details_id, detailsDto);
            return ResponseEntity.ok("상세정보 수정 완료");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
