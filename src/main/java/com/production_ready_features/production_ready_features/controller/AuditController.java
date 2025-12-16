package com.production_ready_features.production_ready_features.controller;

import com.production_ready_features.production_ready_features.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/audit")
public class AuditController {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @GetMapping(path = "/posts/{id}")
    public List<PostEntity> getAllAudits(@PathVariable Long id)
    {
        AuditReader reader= AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> allReaders=reader.getRevisions(PostEntity.class,id);
        return allReaders.stream()
                .map(revisionNumber->reader.find(PostEntity.class,id,revisionNumber))
                .collect(Collectors.toList());

    }
}
