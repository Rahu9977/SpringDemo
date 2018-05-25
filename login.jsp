<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

                <form action='<c:url value="/login" />' method="post" class="margin-bottom-0" autocomplete="off">
                    <div class="form-group m-b-20">
                        <input type="text" name="username" class="form-control input-lg" placeholder="User Name" autofocus="autofocus" required="required"/>
                    </div>
                    <div class="form-group m-b-20">
                        <input type="password" name="password" class="form-control input-lg" placeholder="Password" required="required"/>
                    </div>
                    <div class="login-buttons">
                        <button type="submit" name="login" class="btn btn-success btn-block btn-lg">Sign me in</button>
                     <input type = "hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                </form>
