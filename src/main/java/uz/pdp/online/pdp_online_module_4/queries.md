db.users.find( {"address.zipcode" : { $regex : "4$|9$" } } );
db.users.find( { "address.zipcode": { $regex: /[49]$/ } } );

db.users.find( { "address.geo.lat" : {$lt : "0" } } );

db.users.find( {"website" : { "$regex" : ".com$" } } );
db.users.find( { "website": { $regex: /\.com$/ } } );

db.users.updateOne( { _id : "objectId"}, {$set : { "company.catchPhrase" : "NEW PHRASE", "address.geo.lng" : "NEW VALUE" } } );
