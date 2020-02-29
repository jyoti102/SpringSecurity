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



-----------------------------------------------------------
### SPRING DEFAULT SECURITY
-----------------------------------------------------------
1. Create new project or use the existing project.
2. Create the controller end point.
3. Add dependency spring-boot-starter-security
4. Run the code and hit the end point it will show the default authentication provided.
5. Here everything is handled by spring security like sessions. We don't have to write additional code.
6. Default username is user and default password is the encrypted password in the console.

-----------------------------------------------------------
### ADDING CONFIGURATIONS: USING IN MEMORY USERNAME AND PASSWORD
-----------------------------------------------------------
1. Create security config class and extend a class websecurityconfigureadapter to get all the configuration features.
2. Add the configuration annotation at the class level : @Configuration and @EnableWebSecurity.
3. Override userdetail service method. and add annotation @Bean.
4. In userdetail method:
		create a list of userdetails. UserDetails is a inbuilt class in spring sercurity.
		add object to the list. Use inbuilt user class object. User class have its default password encoder. Add role to authenticate
			- users.add(User.withDefailtPasswordEncoder().username("Jyoti").password("123456").role("USER").build());
		return InMemoryUserDetails Object
			- return new InMemoryUserDetailsManager(usersList);
5. Login and add the credentials.

6. You can directly add the user name and password to the application.property file.

-----------------------------------------------------------
### USING DATABASE FOR USERNAME AND PASSWORD FOR VALIDATION
-----------------------------------------------------------
1. Create security config class with the required annotations
2. Now create the method AuthenticationProvider which will return the object of AuthenticationProvider. Add annotation @Bean
3. In AuthenticationProvider method:
		user DaoAuthenticationProvider which is already implemented.
			 - DaoAuthenticationProvider provider = new DaoAuthenticationProvider()
4. Add required dependency for database connectivity : data JPA and MySQL connector
5. Create a table in database having username and password column. Add some data like username:jyoti and password:singh and configure database with project.  
6. Create the entity class User for the database.  
7. Interaction manner configuration talking to service and service talking to DAO.  
8. In comfig class inside the AuthenticationProvider method:  
		- provider.setUserDetailsService(userDetailsService Object)
		Autowired the object of userDetailsService
		Call the provider in coder to set it to noEncryption.
			- provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

9. Create a class myUserDetailService implementing the UserDetailsService with @service annotation. You will the override method lodeUserByUsername
10. Create a user repository extending JPARepository. add method User findByUsername(String username)
11. Create a class myUserDetails to implement UserDetails. We are not configuring all for now. So we return true for all except getPassword and getUserName.
12. Create object of User in myUserDetails class. Add create constructor for user. Add user.getPassword and user.getUserName in the respective getters.
13. getAuthority will return the collection of authority. So we will return Collection.singleton(new SimpleGrantedAuthority("USER"))
14. Return new myUserDetails object passing user object.
15. And ready to start.


-----------------------------------------------------------
### VALIDATING USERNAME AND PASSWORD WITH ENCRYPTION
-----------------------------------------------------------
1. In the same above code. We will edit the security config class.
2. Instead of NoOpPasswordEncoder we will use (new BCryptPasswordEncoder())




-----------------------------------------------------------
### VALIDATING USERNAME AND PASSWORD USING OUR CUSTOM LOGIN
-----------------------------------------------------------
1. Created our own login, logout, home page.
2. Now we need to disable the default page. Instead of that default page call our own custom page.
3. In security config file, override the config method with HttpSercurity as parameter. 
		//	.authorizeRequests()
		//	.anyRequest().authenticated()
		//	.and()
		//.formLogin().and()
		//.httpBasic();
4. Add configuration to call custom login page
		.formLogin()
			.loginPage("/login").permitAll()
			.and()

5. Invalidate session on logout and redirect it to home page.
		logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("logout"))
			.logoutSuccessUrl("/home").permitAll();
			
6. Now add configuration for url to be authenticated
		.authorizeRequests().antMatchers("/*").permitAll()
			.anyRequest().authenticated()
			.and()
			
7. Final configuration
```java
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/*").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("logout"))
			.logoutSuccessUrl("/home").permitAll();
```
