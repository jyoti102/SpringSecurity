# SpringSecurity
It's a spring boot security demo project.


## Spring security using MySQL database and JPA without encryption.

@SecurityConfig.java
 We are using AuthenticationProvider, it is compatible with all of the authentication mechanisms that generate a UsernamePasswordAuthenticationToken, and is probably the most commonly used provider in the framework.

@UserService.java implementing UserDetailsService
 Overriding the loadUserByUsername method.

@UserDetailImpl.java implementing UserDetails
 Add return type true for isAccountNonExpired, isAccountNonLocked,isCredentialsNonExpired, and isEnable because rightnow we are only validating the username and password.

## Spring security using MySQL database and JPA with encrypted password.
 The code will same as above. Instead of NoOpPasswordEncoder we will use spring boot BCryptPasswordEncoder.