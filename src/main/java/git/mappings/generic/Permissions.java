package git.mappings.generic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permissions {
        @JsonProperty("admin")
        public boolean getAdmin() {
            return this.admin; }
        public void setAdmin(boolean admin) {
            this.admin = admin; }
        boolean admin;
        @JsonProperty("push")
        public boolean getPush() {
            return this.push; }
        public void setPush(boolean push) {
            this.push = push; }
        boolean push;
        @JsonProperty("pull")
        public boolean getPull() {
            return this.pull; }
        public void setPull(boolean pull) {
            this.pull = pull; }
        boolean pull;
}
