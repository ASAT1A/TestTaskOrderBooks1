package com.example.demo.component.controller;

import com.example.demo.component.service.ClientService;
import com.example.demo.programObject.dto.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/client")
@RequiredArgsConstructor
public class ClientRestController {

    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<ClientDto> createClient(@Valid @RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(clientService.createClient(clientDto), HttpStatus.OK);
    }

    @PatchMapping("/changeName")
    public ResponseEntity<ClientDto> changeName(@Valid @RequestParam("client_id") UUID clientid, @RequestParam("name") String name) {
        return new ResponseEntity<>(clientService.changeName(clientid, name), HttpStatus.OK);
    }

    @PatchMapping("/changeBirthday")
    public ResponseEntity<ClientDto> changeBirthday(@Valid @RequestParam("client_id") UUID clientid, @RequestParam("birthday") LocalDate birthday) {
        return new ResponseEntity<>(clientService.changeBirthday(clientid, birthday), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<List<ClientDto>> getById(@Valid @RequestParam("client_id") UUID id) {
        return new ResponseEntity<>(clientService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<ClientDto>> getByName(@Valid @RequestParam("name") String name) {
        return new ResponseEntity<>(clientService.getByName(name), HttpStatus.OK);
    }
}