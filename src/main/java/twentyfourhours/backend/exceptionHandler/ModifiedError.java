package twentyfourhours.backend.exceptionHandler;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class ModifiedError extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest request, ErrorAttributeOptions options) {
        Map<String, Object> newError = super.getErrorAttributes(request, options );
        newError.remove("timestamp");
        return newError;
    }
}
