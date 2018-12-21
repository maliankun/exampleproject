package com.inspur.exampleproject.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspur.exampleproject.entity.DemoTest;

/**
 * jpa 示例
 * @author liyakun
 */
public interface DemoTestRepository extends JpaRepository<DemoTest, Long>{

}
