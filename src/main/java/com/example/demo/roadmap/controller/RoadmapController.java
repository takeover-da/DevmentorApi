package com.example.demo.roadmap.controller;

import com.example.demo.roadmap.dto.RoadmapDTO;
import com.example.demo.roadmap.service.RoadmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roadmap")
public class RoadmapController {

    @Autowired
    RoadmapService roadmapService;

    // 로드맵 등록 (폼 데이터 처리)
    @PostMapping("/register")
    public ResponseEntity<String> register(RoadmapDTO dto) {
        boolean isSuccess = roadmapService.register(dto);
        if (isSuccess) {
            return new ResponseEntity<>("로드맵 등록이 완료되었습니다.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("로드맵 등록에 실패했습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    // 로드맵 목록 조회
    @GetMapping("/list")
    public ResponseEntity<List<RoadmapDTO>> getList() {
        List<RoadmapDTO> list = roadmapService.getList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 로드맵 단건 조회
    @GetMapping("/read")
    public ResponseEntity<RoadmapDTO> read(@RequestParam(name = "roadmapNo") int roadmapNo) {
        RoadmapDTO dto = roadmapService.read(roadmapNo);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // 로드맵 수정
    @PutMapping("/modify")
    public ResponseEntity<String> modify(RoadmapDTO dto) {
        roadmapService.modify(dto);
        return new ResponseEntity<>("로드맵 정보가 수정되었습니다.", HttpStatus.OK);
    }

    // 로드맵 삭제
    @DeleteMapping("/remove")
    public ResponseEntity<String> remove(@RequestParam(name = "roadmapNo") int roadmapNo) {
        roadmapService.remove(roadmapNo);
        return new ResponseEntity<>("로드맵이 삭제되었습니다.", HttpStatus.OK);
    }
}
