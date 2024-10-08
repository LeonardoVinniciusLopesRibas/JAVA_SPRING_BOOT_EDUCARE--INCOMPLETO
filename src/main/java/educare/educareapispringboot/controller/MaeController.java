package educare.educareapispringboot.controller;

import educare.educareapispringboot.dto.MaeDtoResponse;
import educare.educareapispringboot.dto.MaeDtoResponseTable;
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

    @GetMapping("/getMaeById/{id}")
    public ResponseEntity<Mae> getById(@PathVariable Long id){
        return ResponseEntity.ok(maeService.getById(id));
    }

    @GetMapping("/get/mae")
    public ResponseEntity<List<MaeDtoResponseTable>> getMae(@RequestParam String nome, @RequestParam String cpf, @RequestParam String telefone, @RequestParam String endereco){
        List<MaeDtoResponseTable> maeDtoResponseTableList = maeService.getMae(nome, cpf, telefone, endereco);
        if(maeDtoResponseTableList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(maeDtoResponseTableList);
    }

}
