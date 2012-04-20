
file = new File("admin.csv")
stpiColumn = 1
identity = 100
file.splitEachLine(','){ line ->
    stpi = line[stpiColumn].replace('\"', '')
    println "insert into invoice (id, invoiceNumber, STPIApprovalNumberAndDate) values (${identity}, 'unknown', '${stpi}');"
    identity++;
}
