# api-consumption



## See Sql file in main/resource/data.sql

## connection to in-memory h2 database
http://localhost:8080/h2-console <br>
*JDBC URL:*	`jdbc:h2:mem:transit` <br>
username: `sa` <br>
password: `password` <br>

#### Test URL:
http://localhost:8080/NextTrip/Route-MN/EAST/LGPY

## Sample Response:
`
[
{
busNumber: "301",
busTime: "09:00:00",
stopName: "Lingam Pally",
routeName: "Route-MN",
direction: "EAST",
timeRemaining: "21:11:36"
},
{
busNumber: "301A",
busTime: "10:00:00",
stopName: "Lingam Pally",
routeName: "Route-MN",
direction: "EAST",
timeRemaining: "22:11:36"
}
]
`