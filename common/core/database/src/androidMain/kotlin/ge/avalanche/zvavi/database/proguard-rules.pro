# Room database rules
-keep class * extends androidx.room.RoomDatabase { <init>(); }
-keep class ge.avalanche.zvavi.database.** { *; }
-keep class ge.avalanche.zvavi.database.dao.** { *; }
-keep class ge.avalanche.zvavi.database.entities.** { *; }

# Keep Room annotations
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-keep @androidx.room.Dao interface *
-keep @androidx.room.Database class *
-keep @androidx.room.TypeConverter class *
-keep @androidx.room.TypeConverters class * 