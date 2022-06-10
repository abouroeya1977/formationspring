package ma.cigma.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVo  {
	private Long id;
	private String username;
	private String password;
	private List<RoleVo> roles = new ArrayList<RoleVo>();

	private boolean enabled;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;

	public UserVo(String username, String password, List<RoleVo> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public UserVo(String username, String password, List<RoleVo> roles, boolean enabled, boolean 
			accountNonExpired,boolean credentialsNonExpired,boolean accountNonLocked ) {
		this(username,password,roles);
		this.enabled=enabled;
		this.accountNonExpired=accountNonExpired;
		this.credentialsNonExpired=true;
		this.accountNonLocked=accountNonLocked;
	}
}