delete from users;
insert into users (id, name) values (1, 'bill');
insert into users (id, name) values (2, 'fart');


delete from invoice;
insert into invoice(id, invoiceNumber , STPIApprovalNumberAndDate, descriptionOfGoods, currency, foreignCurrency, amountSTPIApproval, CIFValueInINR, bondNumber, bondDate, billOfEntryNumber, billOfEntryDate, assessableValueInINR, dutyExempt, twentyFivePercentDF, CGApprovedInINR, dutyForgone, status, remarks, purchaseOrderNumber, location, dateOfInvoice, supplierNameAndAddress, loanBasis, freeOfCharge ) values (123, 'invoiceNumber123', 'STPIApproval123', 'descriptionOfGoods123', 'currency123', 123, 123, 123, 'bond123', '2012-12-12', 'BOE#123', '2012-12-12', 123, 123, 123, 123, 123, 'status123', 'remarks123', 'PO#123', 'location123', '2012-12-12', 'supplier123',0,0 ), (12345, 'invoiceNumber12345', 'STPIApproval12345', 'descriptionOfGoods12345', 'currency12345', 12345, 12345, 12345, 'bond12345', '2012-12-12', 'BOE#12345', '2012-12-12', 12345, 12345, 12345, 12345, 12345,  'status12345', 'remarks12345', 'PO#12345', 'location12345', '2012-12-12', 'supplier12345', 1,1);

insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (100, 'unknown', 'STPIB/Import/25112011/0043/31733  Dt.28-Nov-2011');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (101, 'unknown', 'STIPB/Import/EXCISEDUTY/23112011/0012/31279  Dt.28-Nov-2011');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (102, 'unknown', 'STPIB/Import/20122011/0090/34724 Dt.20-Dec-2011');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (103, 'unknown', 'STPIB/Import/25012012/0075/38858 Dt.25-Jan-2012');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (104, 'unknown', 'STPIB/Import/12122011/0026/33595 Dt.13-Dec-2011');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (105, 'unknown', 'STPIB/Import/12122011/0025/33594 Dt.13-Feb-2012');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (106, 'unknown', 'STPIB/Import/15022012/0085/41111 Dt.16-Feb-2012');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (107, 'unknown', 'STPIB/Import/06032012/0008/43177 Dt.06-Mar-2012');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (108, 'unknown', 'STPIB/Import/20032012/0011/44863  Dt. 20-Mar-2012');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (109, 'unknown', 'STPIB/Import/20032012/0016/44869  Dt. 20-Mar-2012');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (110, 'unknown', 'STPIB/Import/20032012/0015/44867  Dt. 20-Mar-2012');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (111, 'unknown', 'STPIB/Import/20032012/0010/44860  Dt. 20-Mar-2012');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (112, 'unknown', 'STPIB/Import/20032012/0013/44865  Dt. 20-Mar-2012');
insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (113, 'unknown', 'STPIB/Import/07032012/0111/43513  Dt. 7-Mar-2012');