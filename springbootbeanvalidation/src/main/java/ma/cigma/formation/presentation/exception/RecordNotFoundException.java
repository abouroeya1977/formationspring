package ma.cigma.formation.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = 7733586942874361333L;

	public RecordNotFoundException(String exception) {
        super(exception);
    }
}
