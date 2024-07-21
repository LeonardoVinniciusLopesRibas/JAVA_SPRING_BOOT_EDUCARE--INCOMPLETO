package educare.educareapispringboot.controller;

import educare.educareapispringboot.dto.MaeDtoResponse;
import educare.educareapispringboot.model.Mae;
import educare.educareapispringboot.service.MaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/educare/mae")
public class MaeController {

    @Autowired
    private MaeService maeService;

    @GetMapping("/buscaMaePorParametros")
    public ResponseEntity<List<MaeDtoResponse>> buscaMae(@RequestParam String query){
        List<MaeDtoResponse> maeDtoResponseList = maeService.buscaMae(query);
        if(maeDtoResponseList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(maeDtoResponseList);
    }

    @GetMapping("/buscaMaeById/{id}")
    public ResponseEntity<MaeDtoResponse> getId(@PathVariable Long id){
        return ResponseEntity.ok(maeService.getMaeById(id));
    }

}
