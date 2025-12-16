package com.example.demo.config;

import com.example.demo.audit.Revision;
import org.hibernate.envers.RevisionListener;

/**
 * Listener de Envers para inicializar/capturar datos extra por revisión.
 *
 * <p>Actualmente solo castea la entidad de revisión. Si en el futuro se agregan campos
 * (ej: usuario autenticado, ip, etc.) este es el punto para completarlos.</p>
 */
public class CustomRevisionListener implements RevisionListener {

    public void newRevision(Object revisionEntity){
        final Revision revision = (Revision) revisionEntity;
        // Hook disponible para completar datos adicionales de auditoría.
    }

}