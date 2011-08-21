package com.pp.util.authoritiespopulator;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.ldap.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Repository;

@Repository
public class PeoplePassAuthoritiesPopulator implements LdapAuthoritiesPopulator {

	public GrantedAuthority[] getGrantedAuthorities(DirContextOperations userData,
			String username) {
		GrantedAuthorityImpl grantedAuthorityImpl= new GrantedAuthorityImpl("ROLE_"+"ADMIN");
		GrantedAuthority[] arrayGranted=new GrantedAuthorityImpl[1];
		arrayGranted[0]=grantedAuthorityImpl;
		return arrayGranted;
	}

}
