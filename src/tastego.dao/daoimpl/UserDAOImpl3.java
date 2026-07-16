    @Override
    public boolean updatePassword(String email, String password) {

        String sql = "UPDATE users SET password=? WHERE email=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, password);
            ps.setString(2, email);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean verifyOTP(String email) {

        String sql = "UPDATE users SET otp_verified=true WHERE email=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
