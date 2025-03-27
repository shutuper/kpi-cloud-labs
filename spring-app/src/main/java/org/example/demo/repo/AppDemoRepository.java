package org.example.demo.repo;

import org.example.demo.repo.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppDemoRepository extends JpaRepository<DemoEntity, UUID> {

}
