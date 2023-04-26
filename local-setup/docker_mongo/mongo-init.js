db = db.getSiblingDB("f1fanclub");
db.createUser(
    {
        user: "f1fanclubuser",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "f1fanclub"
            }
        ]
    }
);
db.createCollection("f1_seasons");
db.f1_seasons.insertMany([
    {
        "season_year": "1950",
        "season_wiki": "https://en.wikipedia.org/wiki/1950_Formula_One_season",
    }, 
    {
        "season_year": "1951",
        "season_wiki": "https://en.wikipedia.org/wiki/1951_Formula_One_season",
    }
]);
