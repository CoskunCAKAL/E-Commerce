package com.haratres.controller;

import com.haratres.entity.User;
import com.haratres.entity.Whislist;
import com.haratres.entity.WhislistEntry;
import com.haratres.service.AccountService;
import com.haratres.service.ProductService;
import com.haratres.service.WhislistEntryService;
import com.haratres.service.WhislistService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/whislist")
@RequiredArgsConstructor
public class WhislistController {

    private final WhislistService whislistService;
    private final WhislistEntryService whislistEntryService;

    private final AccountService accountService;

    private final ProductService productService;

    @GetMapping
    public String getAllWhislist(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String mail = authentication.getName();
        User currentUser = accountService.findByUserMail(mail);
        model.addAttribute("whis", currentUser.getWhislists());
        return "whislist/whislist";
    }

    @GetMapping("add/{id}")
    public String saveWhislistEntry(Model model, @PathVariable("id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String mail = authentication.getName();
        User currentUser = accountService.findByUserMail(mail);
        Whislist whislist = currentUser.getWhislists().stream().findFirst().orElse(new Whislist());
        for (WhislistEntry whislistEntry : whislist.getWhislistEntries()) {
            if (whislistEntry.getProduct() == productService.getProductById(id)) {
                return null;
            }
        }
        WhislistEntry entry = new WhislistEntry();
        entry.setProduct(productService.getProductById(id));
        entry.setWhislist(whislist);
        entry.setCreated(null);

        Set<WhislistEntry> entries = whislist.getWhislistEntries() == null ? new HashSet<>() :whislist.getWhislistEntries();
        entries.add(entry);
        whislist.setWhislistEntries(entries);
        whislist.setUser(currentUser);
        whislistService.saveWhislist(whislist);
        //whislistEntryService.saveWhislistEntry(entry);

        return "whislist/whislist-entry";
    }


    @GetMapping("remove/{id}")
    public String removeProduct(Model model, @PathVariable("id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String mail = authentication.getName();
        User currentUser = accountService.findByUserMail(mail);
        Whislist whislist = currentUser.getWhislists().stream().findFirst().orElseThrow();
        for (WhislistEntry whislistEntry : whislist.getWhislistEntries()) {
            if (whislistEntry.getProduct().getId().equals(id)) {
                Long currentWhislistEntryId = whislistEntry.getId();
                whislistEntryService.deleteWhislistEntry(currentWhislistEntryId);

            }
        }
        return "whislist/whislist";
    }

    @GetMapping("remove/whislist/{id}")
    public String removeWhislist(Model model, @PathVariable("id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String mail = authentication.getName();
        User currentUser = accountService.findByUserMail(mail);
        for (Whislist whislist : currentUser.getWhislists()) {
            if (whislist.getId().equals(id)) {
                whislistService.delete(whislist);
            }

        }

        return "whislist/whislist";
    }


}
