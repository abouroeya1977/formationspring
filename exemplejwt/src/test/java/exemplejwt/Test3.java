package exemplejwt;

import ma.formations.jwt.TokenManager;

public class Test3 {
	public static final String TOKEN_1 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY0ODE1NTAwNiwiZXhwIjoxNjQ4MjQxNDA2fQ.PRd2pmfIxgOquAtV3dH9UGkifdg593ikEZglozT34X7cBgBhl_X5CmpzH1xLuFsKCtKMBQxExJmMA5hKGBAUlQ";
	public static final String TOKEN_2 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIkFETUlOIiwiQ0xJRU5UIl0sImV4cCI6MTY0ODI0MTUyMywiaWF0IjoxNjQ4MTU1MTIzfQ.X01ebzV7CgfE9ZbeeKqj8DHsc56z2gJmmXB1enyCUM-aiEzPqSUCpMpLqmSi6Jmw3i7sdOAaoYfc66x7kg5Y2w";

	public static void main(String[] args) {
		try {
			boolean isToken1Valid=TokenManager.validateJwtToken(TOKEN_1);
			boolean isToken2Valid=TokenManager.validateJwtToken(TOKEN_2);
			System.out.println(isToken1Valid);
			System.out.println(isToken2Valid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
