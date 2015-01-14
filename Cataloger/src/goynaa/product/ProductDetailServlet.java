package goynaa.product;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/*
 * Task of ProductDetailServlet
 * 
 * It takes a product it 
 */
public class ProductDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	String product_id = req.getParameter("productid");
	String page_id =req.getParameter("page_id");
	
	
	
	ProductCatalogDetailDAO productCatalogDetail = new ProductCatalogDetailDAO();
	/*
	 * CHECK : If the product actually exists 
	 *
	 *
	 *Initial task is to confirm if the product id that came in actually exists
	 */
	
	int result = productCatalogDetail.checkProductId(product_id); 
	if(result == 0){
	
		req.setAttribute("product_exist", "no");
		req.getRequestDispatcher(page_id).forward(req, resp);

	}
	else {
		
	try {
		Product the_product = productCatalogDetail.getProductDetail(product_id); 
		String type = productCatalogDetail.getProductType(product_id);
		/* 
		 * Product Details that have multiple values and retrive as a list
		 */
		//Catalog Details
		if(type.equals("jewelry")){
			Jewelry j = (Jewelry)the_product;
			List<String> colors = new ArrayList<String>();
			List<String> images = new ArrayList<String>();
			String campaign_image = j.getCampaign_image();
			System.out.println("ProductDetaulsServlet campaign_image value = "+campaign_image);
			
			//List<String> materials = new ArrayList<String>();
			//materials = the_product.getMaterials();
			images = j.getImages();
			colors = j.getColors();
			
			req.setAttribute("product_images", images);
			req.setAttribute("product_colors", colors);
			req.setAttribute("campaign_image", campaign_image);
		}//close if

		//Inventory Details
		//ProductInventoryDetailDAO inventory_detail = new ProductInventoryDetailDAO();
		//double product_unit_price = inventory_detail.getProductUnitPrice(product_id);
		/* DEBUG CODE
		System.out.println(the_product.getColors());
		System.out.println(the_product.getProduct_description());
		System.out.println(the_product.getImages());
		System.out.println(the_product.getClass());
		System.out.println(the_product.getProduct_title());
		 */		
		/*
		 * Common request attributes
		 * Setting request attributes to retrieve in the product.jsp page
		 * Common request attributes are product object, product_id, product_type
		 */
	
		String title = the_product.getProduct_title();
		String description = the_product.getProduct_description();
		
		req.setAttribute("the_product", the_product);
		req.setAttribute("productid", product_id);
		req.setAttribute("product_title", title);
		req.setAttribute("product_description", description);
	
		
	} catch (Exception e) {
		req.setAttribute("error", "Retrieving product details failed.");
		e.printStackTrace();
	}
	finally {
		
		//System.out.println("Value of Update Product:: "+update_product);
		/*
		if(update_product != null){
			System.out.println("rediecting to productupdate.jsp");
			req.getRequestDispatcher("productupdate.jsp").forward(req, resp);
		}
		*/
		
		if(page_id != null)
		{
			System.out.println("rediecting to : "+page_id);
			req.getRequestDispatcher(page_id).forward(req, resp);
			
		}
		else {
			
		String url = "product.jsp";
		System.out.println("rediecting to product.jsp");
		req.getRequestDispatcher(url).forward(req, resp);
	}
		}//close finally
	
		}//close else
	}//close the method
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		doGet(req, resp);
	}
}
