<p>New Invoice</p>
<div>
        <form action="/kabbadi/invoice/new" method="POST">
               <label>Invoice number</label>
        <input name="invoiceNumber" value="${invoice.invoiceNumber}"/>

        <input type="submit" value="Submit invoice" />
        </form>
</div>