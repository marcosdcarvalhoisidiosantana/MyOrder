package com.example.myorder.api.controller;

import com.example.myorder.api.RestPath;
import com.example.myorder.api.dtos.CreateProdutoDto;
import com.example.myorder.api.dtos.ProdutoResponseDto;
import com.example.myorder.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("ProductController")
@RequestMapping(RestPath.BASE_PATH + "/product")
@Api(tags = "Produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    @ApiResponses({
            @ApiResponse(code = 201, message = "Produto Criado", response = ProdutoResponseDto.class)
    })
    public ProdutoResponseDto create(@RequestBody @Valid CreateProdutoDto createProdutoDto) {

        return produtoService.create(createProdutoDto);
    }
}

