package bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class StoreOrderController {

@RequestMapping(value = "/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")

public void accept(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /storeOrder/accept  called #####");
        }

@RequestMapping(value = "/reject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")

public void reject(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /storeOrder/reject  called #####");
        }
 }