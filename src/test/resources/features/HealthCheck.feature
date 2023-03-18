@ui @healthcheck


Feature: here am checking the helth of Amazone
@a
Scenario: user is able to search product and added it to the cart
Given user open the application
And user search for the "Shoes"
And user click on the product from the list
And Selected product open in the new tab
When user Add the product into the cart
Then user will see the payment page
@b
Scenario: user checking the list under user SigninBTN

Given user open the application
When user hover the mouse on account list BTN 
Then 2 main options should be visible 
And list should be visible
|Create a Wish List   |
|Wish from Any Website|
|Baby Wishlist        |
|Discover Your Style  |
|Explore Showroom     |
And user see next list
|Your Account         |
|Your Orders          |
|Your Wish List       |
|Your Recommendations |
|Your Prime Membership|
|Your Prime Video     |
|Your Subscribe & Save Items|
|Memberships & Subscriptions|
|Your Free Amazon Business Account|
|Your Seller Account  |
|Manage Your Content and Devices|

@c
Scenario: User Click on All button and See the differt options 
Given user open the application
When user click on All button
Then Diffrent options displayed
|Best Sellers|
|New Releases|
|Movers and Shakers|
|Amazon miniTV- FREE entertainment|
|Echo & Alexa|
|Fire TV|
|Kindle E-Readers & eBooks|
|Audible Audiobooks|
|Amazon Prime Video|
|Amazon Prime Music|
|Mobiles, Computers|
|TV, Appliances, Electronics|
|Men's Fashion|
|Women's Fashion|
|See All|
|Gift Cards & Mobile Recharges|
|Flight Tickets|
|Clearance store|
|Your Account|
|Customer Service|
|Sign in|
