package br.com.gleisonandrade.bancoapi.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gleisonandrade.bancoapi.security.UserDetailsImpl;
import br.com.gleisonandrade.bancoapi.services.UserService;
import br.com.gleisonandrade.bancoapi.util.JWTUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Atualiza o token do usuário no sistema")
	@ApiResponses(value = {
	    @ApiResponse(code = 204, message = "Token atualizado com sucesso")
	})
	@PostMapping("/refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserDetailsImpl user = userService.getUserDetails();
		
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		
		return ResponseEntity.noContent().build();
	}
}