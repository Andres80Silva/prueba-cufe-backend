
package com.clarisa.controller;

import com.clarisa.model.CufeRequest;
import com.clarisa.model.CufeResponse;
import com.clarisa.service.CufeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cufe")
public class CufeController {

    @Autowired
    private CufeService cufeService;

    @PostMapping("/generate")
    public CufeResponse generateCUFE(@RequestBody CufeRequest request) {
        String cufe = cufeService.generateCUFE(request);
        return new CufeResponse(cufe);
    }
}
