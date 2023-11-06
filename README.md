# rulebased_cache_pattern


```mermaid
graph

subgraph Quarkus App
    subgraph 0_[RuleUnit]
        1_[DRL]
        2_[CacheService]
        3_[DataSource]
    end
    4_["ProductService\n(CacheServiceImpl)"]
    5_[Order Resource]
end

6_[Client]
8_[(Redis)]

6_-->|"call order api"|5_;
5_-->|"insert order / execute rule"|0_;
4_-.->|"implemtents"|2_;
4_-->|"search product"|8_;
1_-->|"call for data load"|2_;
1_-->|"read orders"|3_;
1_-->|"calculate charges"|1_;

```

Sample application for online sales ordering service using Quarkus, Drools, and Redis.
Calculation of charges is performed by RuleUnit of Drools.
By including a service for data access in RuleUnit, Redis can be accessed from the rules.

By using Redis as a cache service, fast data access from rules may be realized.

