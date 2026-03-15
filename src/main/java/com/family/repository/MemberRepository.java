package com.family.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.family.model.Member;

public interface MemberRepository extends JpaRepository<Member,Long>{
}