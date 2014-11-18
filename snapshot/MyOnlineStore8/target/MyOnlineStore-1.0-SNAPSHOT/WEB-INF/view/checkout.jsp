<%-- 
    Document   : checkout
    Created on : Nov 3, 2014, 5:33:16 PM
    Author     : RedPencil
--%>

<div id="singleColumn">

    <h2>checkout</h2>

    <form action="<c:url value='purchase'/>" method="post">
        <table id="checkoutTable">
            <tr>
                <td><label for="first">first name:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="25"
                           maxlength="25"
                           id="first"
                           name="first"
                           value="${param.first}">
                </td>
            </tr>
            <tr>
                <td><label for="last">last name:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="25"
                           maxlength="25"
                           id="last"
                           name="last"
                           value="${param.last}">
                </td>
            </tr>
            <tr>
                <td><label for="address">address:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="address"
                           name="address"
                           value="${param.address}">
                </td>
            </tr>
            <tr>
                <td><label for="state">state:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="2"
                           maxlength="2"
                           id="state"
                           name="state"
                           value="${param.state}">
                </td>
            </tr>
            <tr>
                <td><label for="zip">zip code:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="5"
                           maxlength="5"
                           id="zip"
                           name="zip"
                           value="${param.zip}">
                </td>                
            </tr>          
            <tr>
                <td><label for="email">email:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           value="${param.email}">
            </tr>
            <tr>
                <td><label for="phone">phone:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="10"
                           maxlength="10"
                           id="phone"
                           name="phone"
                           value="${param.phone}">
                </td>
                </td>
            </tr>
            <tr>
                <td><label for="creditcard">credit card number:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="10"
                           maxlength="10"
                           id="creditcard"
                           name="creditcard"
                           value="${param.creditcard}">
                </td>
            </tr>
            <tr>
                <td><label for="cardexp">expire:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="6"
                           maxlength="6"
                           id="cardexp"
                           name="cardexp"
                           value="${param.cardexp}">
                </td>                
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="submit purchase">
                </td>
            </tr>
        </table>
    </form>
</div>
