package org.grails.plugin.hibernate.filter

import grails.transaction.Transactional
import groovy.transform.CompileStatic
import org.hibernate.SessionFactory

@Transactional
@CompileStatic
class HibernateFilterInterceptor {

    SessionFactory sessionFactory

    HibernateFilterInterceptor() {
        matchAll()
    }

    boolean before() {
        def session = sessionFactory.currentSession
        DefaultHibernateFiltersHolder.defaultFilters.each {
            session.enableFilter it
        }
        true
    }
}
