#TODO
[ТВИНО приглашение на тест](https://e.mail.ru/thread/1:31d04bf81b307fdb:0/)

Regards,  
Anastasia Kuchay  
Head of HR, Russia  
Mobile: +7 985 765 7016  
Skype: anastasia.kuchay  

Twino  
123100, Russia, Moscow,  
Presnenskaya Emb.,12, Tower A, floor 25, office 8  

www.twino.eu  
www.ezaem.ru  
www.moneza.ru  
##Problem definition

Create a tiny RESTful web service with the following business requirements:

1. Application must expose REST API endpoints for the following functionality:
    1. apply for loan (loan amount, term, name, surname and personal id must be provided)
    2. list all approved loans
    3. list all approved loans by user
4. Service must perform loan application validation according to the following rules and reject application if:
    1. Application comes from blacklisted personal id
    2. N application / second are received from a single country (essentially we want to limit number of loan applications coming from a country in a given timeframe)
3. Service must perform origin country resolution using a web service (you should choose one) and store country code together with the loan application. Because network is unreliable and services tend to fail, let's agree on default country code - "lv".

##Technical requirements

You have total control over framework and tools, as long as application is written in Java. 
Feel free to write tests in any JVM language.

##What gets evaluated

1. Conformance to business requirements
2. Code quality, including testability
3. How easy it is to run and deploy the service (don't make us install Oracle database please ;)

#####Good luck and have fun!