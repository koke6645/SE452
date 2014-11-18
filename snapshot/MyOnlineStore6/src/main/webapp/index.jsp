<%-- 
    Document   : index
    Created on : Nov 3, 2014, 5:58:06 PM
    Author     : RedPencil
--%>

            
            <div id="login">
                <h2>Please login</h2>
                <form action="login" method="post">
                    <table id="loginTable">
                        <tr>
                            <td><label for="userAcc">User account:</label></td>
                            <td class="inputField">
                                <input type="text"
                                       size="25"
                                       maxlength="25"
                                       id="userAcc"
                                       name="userAcc"
                                       value="${param.userAcc}">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="pass">Password:</label></td>
                            <td class="inputField">
                                <input type="text"
                                       size="25"
                                       maxlength="25"
                                       id="pass"
                                       name="pass"
                                       value="${param.pass}">
                            </td>
                        </tr>   
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="login">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>

            <div id="announce">
                <div id="announceText">
                    <h2>Announcement</h2>
                    <p>[ announcement text ]</p>
                    productImagePath: ${initParam.productImagePath}
                </div>
            </div>
