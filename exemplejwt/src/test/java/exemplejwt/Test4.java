package exemplejwt;

import ma.formations.jwt.TokenManager;

public class Test4 {
	public static final String TOKEN_1 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYzODk2ODE5OSwiZXhwIjoxNjM5MDU0NTk5fQ.I9ppVWS9o5ARboIW9W2zqsIb-nX14UustUT-LIHENSMvDg474rWALCvdne1ZALZXvd3sjE0RZWH8kQ9lbeM6vw";
	public static final String TOKEN_2 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIkFETUlOIiwiQ0xJRU5UIl0sImV4cCI6MTY0ODI0MTUyMywiaWF0IjoxNjQ4MTU1MTIzfQ.X01ebzV7CgfE9ZbeeKqj8DHsc56z2gJmmXB1enyCUM-aiEzPqSUCpMpLqmSi6Jmw3i7sdOAaoYfc66x7kg5Y2w";

	public static void main(String[] args) {
		TokenManager.getDataFromJwtToken(TOKEN_2);
	}

}
