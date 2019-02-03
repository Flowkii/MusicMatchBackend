package at.fhv.mm.Endpoint;

// Start of user code (user defined imports)

import org.springframework.web.bind.annotation.CrossOrigin;

// End of user code
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class AuthEndpoint {
	// Start of user code (user defined attributes)
	
	// End of user code
	
	
	@org.springframework.web.bind.annotation.PostMapping("/login")
	public String login(@org.springframework.web.bind.annotation.RequestParam("email") String email) throws Exception {
		// Start of user code login
		return at.fhv.mm.handlers.AuthHandler.getInstance().login(email);
		// End of user code
	}
	
	@org.springframework.web.bind.annotation.PostMapping("/logout")
	public void logout(@org.springframework.web.bind.annotation.RequestParam("token") String token) throws Exception {
		// Start of user code logout
		 at.fhv.mm.handlers.AuthHandler.getInstance().logout(token);
		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
}
