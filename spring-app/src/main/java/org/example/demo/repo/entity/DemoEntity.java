package org.example.demo.repo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@SuperBuilder
@Entity
@Table(name = "demo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoEntity implements Serializable {

	@Id
	@Builder.Default
	UUID id = UUID.randomUUID();

	String message;

}
