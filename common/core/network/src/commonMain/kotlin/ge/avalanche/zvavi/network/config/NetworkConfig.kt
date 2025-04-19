package ge.avalanche.zvavi.network.config

data class NetworkConfig(
    val baseUrl: String,
    val apiKey: String,
    val connectTimeout: Long = 30_000,
    val readTimeout: Long = 30_000,
    val writeTimeout: Long = 30_000,
    val retryCount: Int = 3,
    val retryDelay: Long = 1000,
    val headers: Map<String, String> = emptyMap()
) {
    companion object {
        fun createDefault() = NetworkConfig(
            baseUrl = "https://gnfghuusszsxjddfousc.supabase.co/rest/v1/",
            apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImduZmdodXVzc3pzeGpkZGZvdXNjIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzI0NDA3ODUsImV4cCI6MjA0ODAxNjc4NX0.eNJiMY-rj6dSOla05KHKMY1-BmuBdoT7G1E-Cb_ETws",
            headers = mapOf("apikey" to "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImduZmdodXVzc3pzeGpkZGZvdXNjIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzI0NDA3ODUsImV4cCI6MjA0ODAxNjc4NX0.eNJiMY-rj6dSOla05KHKMY1-BmuBdoT7G1E-Cb_ETws")
        )
    }
}
