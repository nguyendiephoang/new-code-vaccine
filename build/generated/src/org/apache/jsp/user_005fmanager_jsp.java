package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class user_005fmanager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_scope_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items_end_begin;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_var_value_type;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatNumber_var_value_type = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_scope_nobody.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_forEach_varStatus_var_items_end_begin.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_fmt_formatNumber_var_value_type.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        ");
      dal.AdminDAO a = null;
      synchronized (session) {
        a = (dal.AdminDAO) _jspx_page_context.getAttribute("a", PageContext.SESSION_SCOPE);
        if (a == null){
          a = new dal.AdminDAO();
          _jspx_page_context.setAttribute("a", a, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("            <meta charset=\"UTF-8\">\n");
      out.write("            <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("            <title>Document</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("            <!-- Nạp các tệp JavaScript của jQuery, Popper.js và Bootstrap -->\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("            <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <link rel=\"stylesheet\" href=\"css/bootstrap-4.0.0-dist/css/bootstrap.min.css\">\n");
      out.write("            <!----css3---->\n");
      out.write("            <link rel=\"stylesheet\" href=\"css/custom.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!--google fonts -->\n");
      out.write("\n");
      out.write("            <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("            <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("            <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!--google material icon-->\n");
      out.write("            <link href=\"https://fonts.googleapis.com/css2?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                padding-top: 0px; /* Khoảng cách giữa header và nội dung trang */\n");
      out.write("            }\n");
      out.write("            .fixed-top {\n");
      out.write("                position: fixed;\n");
      out.write("                top: 0;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            td, th {\n");
      out.write("                padding: 0;\n");
      out.write("                width: 100px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .editprofile .modal-body {\n");
      out.write("                padding-bottom: 0px;\n");
      out.write("                padding-left: 0px;\n");
      out.write("                padding-right: 0px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .editprofile .modal-body .container.row {\n");
      out.write("                padding-left: 35px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            .editprofile .modal-footer{\n");
      out.write("                margin-top: 25px\n");
      out.write("            }\n");
      out.write("            .editprofile .modal-content{\n");
      out.write("                width: 200%;\n");
      out.write("                margin-left: -50%;\n");
      out.write("                position: absolute;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("                color: #566787;\n");
      out.write("                background: #f5f5f5;\n");
      out.write("                font-family: 'Varela Round', sans-serif;\n");
      out.write("                font-size: 13px;\n");
      out.write("            }\n");
      out.write("            .table-wrapper {\n");
      out.write("                background: #fff;\n");
      out.write("                padding: 20px 25px;\n");
      out.write("                margin: 30px 0;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                box-shadow: 0 1px 1px rgba(0,0,0,.05);\n");
      out.write("            }\n");
      out.write("            .table-title {\n");
      out.write("                padding-bottom: 15px;\n");
      out.write("                background: #435d7d;\n");
      out.write("                color: #fff;\n");
      out.write("                padding: 16px 30px;\n");
      out.write("                margin: -20px -25px 10px;\n");
      out.write("                border-radius: 3px 3px 0 0;\n");
      out.write("            }\n");
      out.write("            .table-title h2 {\n");
      out.write("                margin: 5px 0 0;\n");
      out.write("                font-size: 24px;\n");
      out.write("            }\n");
      out.write("            .table-title .btn-group {\n");
      out.write("                float: right;\n");
      out.write("            }\n");
      out.write("            .table-title .btn {\n");
      out.write("                color: #fff;\n");
      out.write("                float: right;\n");
      out.write("                font-size: 13px;\n");
      out.write("                border: none;\n");
      out.write("                min-width: 50px;\n");
      out.write("                border-radius: 2px;\n");
      out.write("                border: none;\n");
      out.write("                outline: none !important;\n");
      out.write("                margin-left: 10px;\n");
      out.write("            }\n");
      out.write("            .table-title .btn i {\n");
      out.write("                float: left;\n");
      out.write("                font-size: 21px;\n");
      out.write("                margin-right: 5px;\n");
      out.write("            }\n");
      out.write("            .table-title .btn span {\n");
      out.write("                float: left;\n");
      out.write("                margin-top: 2px;\n");
      out.write("            }\n");
      out.write("            table.table tr th, table.table tr td {\n");
      out.write("                border-color: #e9e9e9;\n");
      out.write("                padding: 12px 15px;\n");
      out.write("                vertical-align: middle;\n");
      out.write("            }\n");
      out.write("            table.table tr th:first-child {\n");
      out.write("                width: 60px;\n");
      out.write("            }\n");
      out.write("            table.table tr th:last-child {\n");
      out.write("                width: 100px;\n");
      out.write("            }\n");
      out.write("            table.table-striped tbody tr:nth-of-type(odd) {\n");
      out.write("                background-color: #fcfcfc;\n");
      out.write("            }\n");
      out.write("            table.table-striped.table-hover tbody tr:hover {\n");
      out.write("                background: #f5f5f5;\n");
      out.write("            }\n");
      out.write("            table.table th i {\n");
      out.write("                font-size: 13px;\n");
      out.write("                margin: 0 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            table.table td:last-child i {\n");
      out.write("                opacity: 0.9;\n");
      out.write("                font-size: 22px;\n");
      out.write("                margin: 0 5px;\n");
      out.write("            }\n");
      out.write("            table.table td a {\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: #566787;\n");
      out.write("                display: inline-block;\n");
      out.write("                text-decoration: none;\n");
      out.write("                outline: none !important;\n");
      out.write("            }\n");
      out.write("            table.table td a:hover {\n");
      out.write("                color: #2196F3;\n");
      out.write("            }\n");
      out.write("            table.table td a.edit {\n");
      out.write("                color: #FFC107;\n");
      out.write("            }\n");
      out.write("            table.table td a.delete {\n");
      out.write("                color: #F44336;\n");
      out.write("            }\n");
      out.write("            table.table td i {\n");
      out.write("                font-size: 19px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            /* Modal styles */\n");
      out.write("\n");
      out.write("            /*            .modal .modal-header, .modal .modal-body, .modal .modal-footer {\n");
      out.write("                            padding: 20px 30px;\n");
      out.write("                        }*/\n");
      out.write("            .modal .modal-content {\n");
      out.write("                border-radius: 3px;\n");
      out.write("            }\n");
      out.write("            .modal .modal-footer {\n");
      out.write("                background: #ecf0f1;\n");
      out.write("                border-radius: 0 0 3px 3px;\n");
      out.write("            }\n");
      out.write("            .modal .modal-title {\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("            .modal .form-control {\n");
      out.write("                border-radius: 2px;\n");
      out.write("                box-shadow: none;\n");
      out.write("                border-color: #dddddd;\n");
      out.write("            }\n");
      out.write("            .modal textarea.form-control {\n");
      out.write("                resize: vertical;\n");
      out.write("            }\n");
      out.write("            .modal .btn {\n");
      out.write("                border-radius: 2px;\n");
      out.write("                min-width: 100px;\n");
      out.write("            }\n");
      out.write("            .modal form label {\n");
      out.write("                font-weight: normal;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            /*vaccine*/\n");
      out.write("            /* Tùy chỉnh độ rộng của cột \"Detail Vaccine\" */\n");
      out.write("            .detail-column {\n");
      out.write("                width: 30%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Ẩn nội dung dài */\n");
      out.write("            .detail-content.collapsed {\n");
      out.write("                height: 50px; /* Chiều cao khởi tạo */\n");
      out.write("                overflow: hidden;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Hiển thị nút \"Hiển thị\" và \"Ẩn\" */\n");
      out.write("            .toggle-button {\n");
      out.write("                cursor: pointer;\n");
      out.write("                color: blue;\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("            footer.footer {\n");
      out.write("                margin-top: 16%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_fmt_formatNumber_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"body-overlay\"></div>\n");
      out.write("\n");
      out.write("            <!-------------------------sidebar------------>\n");
      out.write("            <!-- Sidebar  -->\n");
      out.write("            <nav id=\"sidebar\">\n");
      out.write("                <div class=\"sidebar-header\">\n");
      out.write("                    <h3><img src=\"images/logo.png\" class=\"img-fluid\" style=\"width:100px; border-radius:50%;\" /></h3>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"list-unstyled components\">\n");
      out.write("                    <li >\n");
      out.write("                        <a href=\"#\" ><i class=\"material-icons\">dashboard</i>\n");
      out.write("                            <span>Admin</span></a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <li class=\"\">\n");
      out.write("                        <a href=\"AdminManagerVaccine.jsp\" ><i class=\"material-icons\">date_range</i><span>Vaccine Manager</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"\">\n");
      out.write("                        <a href=\"hospital_manager.jsp\" ><i class=\"material-icons\">date_range</i><span>Hospital Manager</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"active\">\n");
      out.write("                        <a href=\"user_manager.jsp\" ><i class=\"material-icons\">date_range</i><span>User Manager</span></a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"\">\n");
      out.write("                        <a href=\"#\" class=\"nav-link\"><i class=\"material-icons\">library_books</i><span>Calender\n");
      out.write("                            </span></a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!--------page-content---------------->\n");
      out.write("\n");
      out.write("            <div id=\"content\">\n");
      out.write("\n");
      out.write("                <!--top--navbar----design--------->\n");
      out.write("\n");
      out.write("                <div class=\"top-navbar\">\n");
      out.write("                    <div class=\"xp-topbar\">\n");
      out.write("\n");
      out.write("                        <!-- Start XP Row -->\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <!-- Start XP Col -->\n");
      out.write("                            <div class=\"col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center\">\n");
      out.write("                                <div class=\"xp-menubar\">\n");
      out.write("                                    <span class=\"material-icons text-white\">signal_cellular_alt\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- End XP Col -->\n");
      out.write("\n");
      out.write("                            <!-- Start XP Col -->\n");
      out.write("                            <div class=\"col-md-5 col-lg-3 order-3 order-md-2\">\n");
      out.write("                                <div class=\"xp-searchbar\">\n");
      out.write("                                    <form>\n");
      out.write("                                        <div class=\"input-group\">\n");
      out.write("                                            <input type=\"search\" class=\"form-control\" placeholder=\"Search\">\n");
      out.write("                                            <div class=\"input-group-append\">\n");
      out.write("                                                <button class=\"btn\" type=\"submit\" id=\"button-addon2\">GO</button>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- End XP Col -->\n");
      out.write("\n");
      out.write("                            <!-- Start XP Col -->\n");
      out.write("                            <div class=\"col-10 col-md-6 col-lg-8 order-1 order-md-3\">\n");
      out.write("                                <div class=\"xp-profilebar text-right\">\n");
      out.write("                                    <nav class=\"navbar p-0\">\n");
      out.write("                                        <ul class=\"nav navbar-nav flex-row ml-auto\">\n");
      out.write("                                            <li class=\"dropdown nav-item active\">\n");
      out.write("                                                <a href=\"#\" class=\"nav-link\" data-toggle=\"dropdown\">\n");
      out.write("                                                    <span class=\"material-icons\">notifications</span>\n");
      out.write("                                                    <span class=\"notification\">4</span>\n");
      out.write("                                                </a>\n");
      out.write("                                                <ul class=\"dropdown-menu\">\n");
      out.write("                                                    <li>\n");
      out.write("                                                        <a href=\"#\">You have 5 new messages</a>\n");
      out.write("                                                    </li>\n");
      out.write("                                                    <li>\n");
      out.write("                                                        <a href=\"#\">You're now friend with Mike</a>\n");
      out.write("                                                    </li>\n");
      out.write("                                                    <li>\n");
      out.write("                                                        <a href=\"#\">Wish Mary on her birthday!</a>\n");
      out.write("                                                    </li>\n");
      out.write("                                                    <li>\n");
      out.write("                                                        <a href=\"#\">5 warnings in Server Console</a>\n");
      out.write("                                                    </li>\n");
      out.write("\n");
      out.write("                                                </ul>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li class=\"nav-item\">\n");
      out.write("                                                <a class=\"nav-link\" href=\"#\">\n");
      out.write("                                                    <span class=\"material-icons\">question_answer</span>\n");
      out.write("\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li class=\"nav-item dropdown\">\n");
      out.write("                                                <a class=\"nav-link\" href=\"#\" data-toggle=\"dropdown\">\n");
      out.write("                                                    <img src=\"images/user_admin.jpg\" style=\"width:40px; border-radius:50%;\" />\n");
      out.write("                                                    <span class=\"xp-user-live\"></span>\n");
      out.write("                                                </a>\n");
      out.write("                                                <ul class=\"dropdown-menu small-menu\">\n");
      out.write("                                                    <li>\n");
      out.write("                                                        <a href=\"#\">\n");
      out.write("                                                            <span class=\"material-icons\">\n");
      out.write("                                                                person_outline\n");
      out.write("                                                            </span>Profile\n");
      out.write("\n");
      out.write("                                                        </a>\n");
      out.write("                                                    </li>\n");
      out.write("                                                    <li>\n");
      out.write("                                                        <a href=\"#\"><span class=\"material-icons\">\n");
      out.write("                                                                settings\n");
      out.write("                                                            </span>Settings</a>\n");
      out.write("                                                    </li>\n");
      out.write("                                                    <li>\n");
      out.write("                                                        <a href=\"logoutController\"><span class=\"material-icons\">\n");
      out.write("                                                                logout</span>Logout</a>\n");
      out.write("                                                    </li>\n");
      out.write("                                                </ul>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </nav>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- End XP Col -->\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <!-- End XP Row -->\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"xp-breadcrumbbar text-center\">\n");
      out.write("                        <h4 class=\"page-title\">Manage User</h4>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"table-wrapper\">\n");
      out.write("                        <div class=\"table-title\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-sm-6\">\n");
      out.write("                                    <h2>Manage <b>User</b></h2>\n");
      out.write("                                </div>\n");
      out.write("                                <!--                        <div class=\"col-sm-6\">\n");
      out.write("                                \n");
      out.write("                                                                                        <a href=\"AddVaccine.jsp \"  class=\"btn btn-primary edit-btn\"><i class=\"material-icons\">&#xE147;</i><span>Add Vaccine</span></a> \n");
      out.write("                                                                                        <a href=\"#\" class=\"btn btn-primary edit-btn\" data-toggle=\"modal\" data-target=\"#addVaccineModal\"><i class=\"material-icons\">&#xE147;</i><span>Add Vaccine</span></a>\n");
      out.write("                                                            <a href=\"#\" class=\"btn btn-primary edit-btn\" data-toggle=\"modal\" data-target=\"#addModal\">\n");
      out.write("                                                                <i class=\"material-icons\">&#xE147;</i>\n");
      out.write("                                                                <span>Add Hospital</span>\n");
      out.write("                                                            </a>\n");
      out.write("                                \n");
      out.write("                                                        </div>-->\n");
      out.write("                            </div>\n");
      out.write("                        </div>      \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            if (session.getAttribute("updateinforsucess") != null) {
                        
      out.write("\n");
      out.write("                        <script>\n");
      out.write("                            alert(\"");
      out.print( session.getAttribute("updateinforsucess"));
      out.write("\");\n");
      out.write("                        </script>\n");
      out.write("                        ");

                                // Xóa session để không hiển thị lại khi người dùng tải lại trang
                                session.removeAttribute("updateinforsucess");
                            }
                        
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            if (session.getAttribute("delete") != null) {
                        
      out.write("\n");
      out.write("                        <script>\n");
      out.write("                            alert(\"");
      out.print( session.getAttribute("delete"));
      out.write("\");\n");
      out.write("                        </script>\n");
      out.write("                        ");

                                // Xóa session để không hiển thị lại khi người dùng tải lại trang
                                session.removeAttribute("delete");
                            }
                        
      out.write("   \n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            if (session.getAttribute("resetPass") != null) {
                        
      out.write("\n");
      out.write("                        <script>\n");
      out.write("                            alert(\"");
      out.print( session.getAttribute("resetPass"));
      out.write("\");\n");
      out.write("                        </script>\n");
      out.write("                        ");

                                // Xóa session để không hiển thị lại khi người dùng tải lại trang
                                session.removeAttribute("resetPass");
                            }
                        
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div id=\"product-manager \" class=\"container \" >\n");
      out.write("                            <table class=\"table table-striped table-hover \">\n");
      out.write("\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>Serial</th>\n");
      out.write("                                        <th>ID</th>\n");
      out.write("                                        <th>Name</th>\n");
      out.write("                                        <th>Phone</th>\n");
      out.write("                                        <th>Email</th>\n");
      out.write("                                        <th>Actions</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>    \n");
      out.write("                    </div>\n");
      out.write("                         </div>\n");
      out.write("\n");
      out.write("                    <div    >\n");
      out.write("             \n");
      out.write("                \n");
      out.write("                <ul class=\"pagination\">\n");
      out.write("                    <li class=\"page-item disabled\"><a href=\"user_manager.jsp?page=1\">Previous</a></li>\n");
      out.write("                    <li class=\"page-item\"><a href=\"user_manager.jsp?page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page-1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"page-link\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page-1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("                    <li class=\"page-item active\"><a href=\"#\" class=\"page-link\">");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write("</a>\n");
      out.write("                    <li class=\"page-item\"><a href=\"user_manager.jsp?page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page+1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"page-link\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page+1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("                    <li class=\"page-item\"><a href=\"user_manager.jsp?page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${maxpage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Next</li>\n");
      out.write("                   \n");
      out.write("                  </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!--footer-->\n");
      out.write("                <footer class=\"footer\">\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <div class=\"footer-in\">\n");
      out.write("                            <p class=\"mb-0\">&copy 2020 Vishweb design - All Rights Reserved.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("                 <script src=\"assets/js/managerjs.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("                </body>\n");
      out.write("\n");
      out.write("                </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("page");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.page}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_0.setScope("session");
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page<=0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_set_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_set_1.setVar("page");
    _jspx_th_c_set_1.setValue(new String("1"));
    _jspx_th_c_set_1.setScope("session");
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_set_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_set_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_set_2.setVar("page");
    _jspx_th_c_set_2.setValue(new String("1"));
    _jspx_th_c_set_2.setScope("session");
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty page}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_set_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_set_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_set_3.setVar("page");
    _jspx_th_c_set_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_3.setScope("session");
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_var_value_type.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent(null);
    _jspx_th_fmt_formatNumber_0.setType("number");
    _jspx_th_fmt_formatNumber_0.setVar("maxpage");
    _jspx_th_fmt_formatNumber_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Math.ceil(a.allUser.size()/2)}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_eval_fmt_formatNumber_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_fmt_formatNumber_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_fmt_formatNumber_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_fmt_formatNumber_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_fmt_formatNumber_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_fmt_formatNumber_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_var_value_type.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_var_value_type.reuse(_jspx_th_fmt_formatNumber_0);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page>=maxpage}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_set_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_set_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_4.setPageContext(_jspx_page_context);
    _jspx_th_c_set_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
    _jspx_th_c_set_4.setVar("page");
    _jspx_th_c_set_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${maxpage}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_set_4.setScope("session");
    int _jspx_eval_c_set_4 = _jspx_th_c_set_4.doStartTag();
    if (_jspx_th_c_set_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_4);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_4);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${a.allUser}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("i");
    _jspx_th_c_forEach_0.setBegin(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(page-1)*10}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_0.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page*10-1}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_0.setVarStatus("loop");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("     \n");
          out.write("                                        <tr>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loop.index + 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("\n");
          out.write("\n");
          out.write("                                            <td style=\"display: flex; flex-direction: row\" >  \n");
          out.write("                                                <a href=\"#\" class=\" edit-btn\" data-toggle=\"modal\" data-target=\"#editModal");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" >\n");
          out.write("                                                    <i class=\"material-icons\"  title=\"Edit\">&#xE147;</i>\n");
          out.write("                                                </a>\n");
          out.write("                                                <a href=\"#\" class=\"delete\" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><i class=\"material-icons\" title=\"Delete\">&#xE872;</i></a>\n");
          out.write("                                                <a href=\"#\" style=\"color: blue\" data-bs-toggle=\"modal\" data-bs-target=\"#resetPass");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><i class=\"material-icons\" title=\"Reset Password\">&#xeade;</i></a>\n");
          out.write("                                            </td>\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("                                            <!--reset Password-->\n");
          out.write("\n");
          out.write("                                    <div class=\"modal fade\" id=\"resetPass");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" tabindex=\"-1\" role=\"dialog\"\n");
          out.write("                                         aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
          out.write("                                        <div class=\"modal-dialog\">\n");
          out.write("                                            <div class=\"modal-content\">\n");
          out.write("                                                <div class=\"modal-header\">\n");
          out.write("                                                    <h5 class=\"modal-title\" id=\"exampleModalLabel\"><i class=\"bi bi-trash-fill\"></i>\n");
          out.write("                                                        Reset password</h5>\n");
          out.write("                                                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"\n");
          out.write("                                                            aria-label=\"Close\">&times;</button>\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"modal-body\">\n");
          out.write("                                                    Are you sure to reset password this User?\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"modal-footer\">\n");
          out.write("                                                    <form action=\"ResetPasswordUserByAdminController\" method=\"Post\">\n");
          out.write("                                                        <input type=\"search\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"idUser\" hidden>\n");
          out.write("                                                        <input type=\"search\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"email\" hidden>\n");
          out.write("                                                        <!-- <input type=\"search\" value=\"w\" name=\"pid\" hidden> -->\n");
          out.write("                                                        <button type=\"submit\" class=\"btn btn-primary\">Yes</button>\n");
          out.write("                                                        <button type=\"button\" class=\"btn btn-secondary\"\n");
          out.write("                                                                data-bs-dismiss=\"modal\">No</button>\n");
          out.write("                                                    </form>\n");
          out.write("                                                </div>\n");
          out.write("                                            </div>\n");
          out.write("                                        </div>\n");
          out.write("                                    </div>\n");
          out.write("\n");
          out.write("\n");
          out.write("                                    <!--delete-->\n");
          out.write("\n");
          out.write("                                    <div class=\"modal fade\" id=\"exampleModal");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" tabindex=\"-1\" role=\"dialog\"\n");
          out.write("                                         aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
          out.write("                                        <div class=\"modal-dialog\">\n");
          out.write("                                            <div class=\"modal-content\">\n");
          out.write("                                                <div class=\"modal-header\">\n");
          out.write("                                                    <h5 class=\"modal-title\" id=\"exampleModalLabel\"><i class=\"bi bi-trash-fill\"></i>\n");
          out.write("                                                        Delete</h5>\n");
          out.write("                                                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"\n");
          out.write("                                                            aria-label=\"Close\">&times;</button>\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"modal-body\">\n");
          out.write("                                                    Are you sure to delete this User?\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"modal-footer\">\n");
          out.write("                                                    <form action=\"DeleteUserByAdminController\" method=\"Post\">\n");
          out.write("                                                        <input type=\"search\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"idUser\" hidden>\n");
          out.write("                                                        <!-- <input type=\"search\" value=\"w\" name=\"pid\" hidden> -->\n");
          out.write("                                                        <button type=\"submit\" class=\"btn btn-primary\">Yes</button>\n");
          out.write("                                                        <button type=\"button\" class=\"btn btn-secondary\"\n");
          out.write("                                                                data-bs-dismiss=\"modal\">No</button>\n");
          out.write("                                                    </form>\n");
          out.write("                                                </div>\n");
          out.write("                                            </div>\n");
          out.write("                                        </div>\n");
          out.write("                                    </div>\n");
          out.write("\n");
          out.write("                                    <!--edit-->\n");
          out.write("\n");
          out.write("                                    <div class=\"modal fade editprofile\" id=\"editModal");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"editModalLabel\"\n");
          out.write("                                         aria-hidden=\"true\">\n");
          out.write("                                        <div class=\"modal-dialog modal-lg\" role=\"document\">\n");
          out.write("                                            <div class=\"modal-content\">\n");
          out.write("                                                <div class=\"modal-header\">\n");
          out.write("                                                    <h5 class=\"modal-title\" id=\"editModalLabel\">Edit User</h5>\n");
          out.write("                                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
          out.write("                                                        <span aria-hidden=\"true\">&times;</span>\n");
          out.write("                                                    </button>\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"modal-body\">\n");
          out.write("                                                    <!--form chỉnh sửa-->\n");
          out.write("                                                    <form class=\"form\" action=\"UpdateUserByAdminController\" method=\"post\"\n");
          out.write("                                                          id=\"infor\">\n");
          out.write("                                                        <input type=\"search\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.idUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"idUser\" hidden>\n");
          out.write("                                                        <div class=\"container row\">\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("                                                            <div class=\"col-sm-12\">\n");
          out.write("                                                                <label for=\"first_name\">\n");
          out.write("                                                                    <h6>User name</h6>\n");
          out.write("                                                                </label>\n");
          out.write("\n");
          out.write("                                                                <input required type=\"text\" class=\"form-control\"\n");
          out.write("                                                                       name=\"name\" id=\"first_name\"\n");
          out.write("                                                                       value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" />\n");
          out.write("                                                            </div>\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("                                                            <div class=\"col-sm-6\">\n");
          out.write("                                                                <label for=\"last_name\">\n");
          out.write("                                                                    <h6>Gender</h6>\n");
          out.write("                                                                </label>\n");
          out.write("\n");
          out.write("                                                                <select name=\"gender\" class=\"form-control\" id=\"gender\">\n");
          out.write("                                                                    <option value=\"false\" >Female</option>\n");
          out.write("                                                                    <option value=\"true\" >Male</option>\n");
          out.write("                                                                </select>                                                                                \n");
          out.write("                                                            </div>\n");
          out.write("                                                            <div class=\"col-sm-6\">\n");
          out.write("                                                                <label for=\"phone\">\n");
          out.write("                                                                    <h6>Date of birth</h6>\n");
          out.write("                                                                </label>\n");
          out.write("                                                                <input required name =\"dob\" type=\"date\" class=\"form-control\" placeholder aria-label=\"Phone number\"\n");
          out.write("                                                                       value=\"\">\n");
          out.write("                                                            </div>\n");
          out.write("\n");
          out.write("\n");
          out.write("                                                            <div class=\"col-sm-6\">\n");
          out.write("                                                                <label for=\"mobile\">\n");
          out.write("                                                                    <h6>Mobile</h6>\n");
          out.write("                                                                </label>\n");
          out.write("                                                                <input required type=\"text\" class=\"form-control\"\n");
          out.write("                                                                       name=\"phone\" id=\"mobile\"\n");
          out.write("                                                                       value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" />\n");
          out.write("                                                            </div>\n");
          out.write("\n");
          out.write("                                                            <div class=\"col-sm-6\">\n");
          out.write("                                                                <label for=\"email\">\n");
          out.write("                                                                    <h6>Email</h6>\n");
          out.write("                                                                </label>\n");
          out.write("                                                                <input required type=\"email\" class=\"form-control\"\n");
          out.write("                                                                       name=\"email\" id=\"email\"\n");
          out.write("                                                                       value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"/>\n");
          out.write("                                                            </div>\n");
          out.write("\n");
          out.write("                                                            <div class=\"col-sm-6\">\n");
          out.write("                                                                <label for=\"email\">\n");
          out.write("                                                                    <h6>Identification</h6>\n");
          out.write("                                                                </label>\n");
          out.write("                                                                <input required type=\"text\" class=\"form-control\"\n");
          out.write("                                                                       id=\"location\" name=\"identification\"\n");
          out.write("                                                                       value=\"\"/>\n");
          out.write("\n");
          out.write("                                                            </div>\n");
          out.write("\n");
          out.write("                                                            <div class=\"col-sm-6\">\n");
          out.write("                                                                <label for=\"email\">\n");
          out.write("                                                                    <h6>Health Insurance</h6>\n");
          out.write("                                                                </label>\n");
          out.write("                                                                <input required type=\"text\" class=\"form-control\"\n");
          out.write("                                                                       id=\"location\" name=\"healthInsurance\"\n");
          out.write("                                                                       value=\"\"/>\n");
          out.write("\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </div>\n");
          out.write("                                                        <div class=\"modal-footer\">\n");
          out.write("                                                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
          out.write("                                                            <button type=\"submit\" class=\"btn btn-primary save-button\">Save changes</button>\n");
          out.write("                                                        </div>\n");
          out.write("                                                    </form>\n");
          out.write("                                                </div>\n");
          out.write("                                            </div>\n");
          out.write("                                        </div>\n");
          out.write("                                    </div>\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items_end_begin.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${page}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
