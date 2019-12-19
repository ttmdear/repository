package com.ttmdear.jokes.guru.controllers;

import com.ttmdear.jokes.guru.services.CaseAService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/case-a")
@Profile("pl")
public class CaseAController {
    CaseAService caseAService;

    public CaseAController(CaseAService caseAService) {
        this.caseAService = caseAService;
    }

    @RequestMapping({""})
    @ResponseBody
    public String index() {
        return caseAService.getMessage();
    }
}
