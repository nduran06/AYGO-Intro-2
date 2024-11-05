db.createUser(
	{
            user: "nduran06",
            pwd: "aygopass123",
            roles: [
                {
                    role: "readWrite",
                    db: "aygoDB"
                }
            ]
	}
);

