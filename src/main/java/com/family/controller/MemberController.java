package com.family.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.family.model.Member;
import com.family.service.MemberService;

@RestController
@CrossOrigin
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService service;

    @GetMapping
    public List<Member> getMembers(){
        return service.getMembers();
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id){
        return service.getMember(id);
    }

    @PostMapping
    public Member addMember(@RequestBody Member member){
        return service.saveMember(member);
    }

    // ---------- UPDATE MEMBER ----------
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
        Member member = service.getMember(id);
        if(member == null) {
            return ResponseEntity.notFound().build();
        }

        member.setName(updatedMember.getName());
        member.setAge(updatedMember.getAge());
        member.setPhone(updatedMember.getPhone());
        member.setBloodGroup(updatedMember.getBloodGroup());
        member.setAdditionalInfo(updatedMember.getAdditionalInfo());
        member.setPhotoUrl(updatedMember.getPhotoUrl());

        Member savedMember = service.saveMember(member);
        return ResponseEntity.ok(savedMember);
    }
}