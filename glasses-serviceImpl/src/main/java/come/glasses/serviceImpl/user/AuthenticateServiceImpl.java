package come.glasses.serviceImpl.user;

import come.glasses.entity.UserEntity;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-08-21 10:20
 */
public class AuthenticateServiceImpl extends AbstractAuthenticationToken {


    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     * represented by this authentication object.
     */

    private final UserEntity userEntity;

    private SimpleGrantedAuthority authorities;

    public AuthenticateServiceImpl(UserEntity authEntity) {
        super(null);
        this.userEntity = authEntity;
//        this.authorities = new SimpleGrantedAuthority(this.User != null ? this.User.getRoleId().toString() : null);
    }

    @Override
    public UserEntity getPrincipal() {
        return this.userEntity;
    }

    @Override
    public SimpleGrantedAuthority getCredentials() {
        return this.authorities;
    }
}
