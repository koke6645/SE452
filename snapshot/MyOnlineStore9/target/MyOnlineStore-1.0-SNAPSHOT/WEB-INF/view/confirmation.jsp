<%-- 
    Document   : confirmation
    Created on : Nov 3, 2014, 5:33:37 PM
    Author     : RedPencil
--%>



<div id="singleColumn">

    <p id="confirmationText">
        <h4>confirmation</h4>
        <strong>Your order has been successfully processed and will be delivered within 24 hours.</strong>
        <br><br>
        Thank you for shopping at the Affable Bean Green Grocer!
    </p>

    <div class="summaryColumn" >

        <table id="orderSummaryTable" class="detailsTable">
            <tr class="header">
                <th colspan="3">order summary</th>
            </tr>

            <tr class="tableHeading">
                <td>product</td>
                <td>quantity</td>
                <td>price</td>
            </tr>

            <c:forEach var="orderItems" items="${orderItems}" varStatus="iter">

                <tr class="${((iter.index % 2) != 0) ? 'lightBlue' : 'white'}">
                    <td>${products[iter.index].name}</td>
                    <td class="quantityColumn">
                        ${orderedProduct.quantity}
                    </td>
                    <td class="confirmationPriceColumn">
                        &euro; ${products[iter.index].price * orderedProduct.quantity}
                    </td>
                </tr>

            </c:forEach>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="2" id="totalCellLeft"><strong>total:</strong></td>
                <td id="totalCellRight">$ ${orderRecord.amount}</td>
            </tr>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="3" id="dateProcessedRow"><strong>date processed:</strong>
                    ${orderRecord.dateCreated}
                </td>
            </tr>
        </table>

    </div>

    <div class="summaryColumn" >

        <table id="deliveryAddressTable" class="detailsTable">
            <tr class="header">
                <th colspan="3">delivery address</th>
            </tr>

            <tr>
                <td colspan="3" class="lightBlue">
                    ${customer.name}
                    <br>
                    ${customer.address}
                    <br>
                    Prague ${customer.cityRegion}
                    <br>
                    <hr>
                    <strong>email:</strong> ${customer.email}
                    <br>
                    <strong>phone:</strong> ${customer.phone}
                </td>
            </tr>
        </table>

    </div>
</div>