package com.kiaora.masterproject.remote.api;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface APIService {

    // google api call
    @GET
    Call<String> getDataFromGoogleApi(
            @Url String url
    );

 /*   // @FormUrlEncoded
    @POST("master_data")
    Call<RegisterLoadResult> getRegisterLoad();

    @GET("locations")
    Call<Locations> getLocations();

    @GET("driver_vehicles")
    Call<Vehicles> getDriverVehicles();

    @FormUrlEncoded
    @POST("driver_register")
    Call<RegisterResult> createDriver(
            @Field("first_name") String firstName,
            @Field("last_name") String lastName,
            // @Field("email_id") String emailId,
            @Field("mobile_number") String mobileNumber,
            @Field("m_location_id") int locationId,
            @Field("vehicle_type_id") int vehicleId,
            @Field("device_id") String device_id
            // @Field("password") String password
            // @Field("address") String address,
            // @Field("landmark") String landmark,
            // @Field("city") String city,
            // @Field("state") String state,
            // @Field("vehicle") String vehicle,
            // @Field("about") String about
    );

    @FormUrlEncoded
    @POST("driver_login")
    Call<LoginResult> driverLogin(
            @Field("mobile_number") String mobileNumber,
            @Field("registration_id") String registerId,
            @Field("device_id") String deviceId
    );

    @GET("driver")
    Call<Driver> getDriver();

    @FormUrlEncoded
    @POST("driver_current_location")
    Call<ServerResult> driverCurrentLocation(
            @Field("driver_id") int driverId,
            @Field("current_latitude") double latitude,
            @Field("current_longitude") double longitude,
            @Field("accuracy") float accuracy
    );

    @FormUrlEncoded
    @POST("driver_status")
    Call<ServerResult> dutyStatus(@Field("driver_id") int driverId,
                                  @Field("master_online_state_id") int state);

    @FormUrlEncoded
    @POST("get_accept_trip")
    Call<CustomerTripDetailsResult> tripComing(
            @Field("driver_id") int driverId,
            @Field("customer_id") int customerId,
            // @Field("m_vehicle_id") int mVehicleId,
            @Field("device_id") String deviceId
    );

    @FormUrlEncoded
    @POST("get_customer_trip_status")
    Call<CustomerResult> tripInComing(
            @Field("driver_id") int driverId,
            @Field("accept_status_id") int acceptStatusId
    );

    @FormUrlEncoded
    @POST("driver_profile")
    Call<ProfileResult> driverProfile(
            @Field("driver_id") int driverId
    );

    @FormUrlEncoded
    @POST("driver_profile_update")
    Call<ProfileResult> driverProfileUpdate(
            @Field("driver_id") int driverId,
            @Field("mobile_number") String mobileNumber,
            @Field("emergency_mobile_number") String emergencyMobileNumber,
            @Field("driver_lic_no") String driverLicNo
    );

    @FormUrlEncoded
    @POST("update_accept_trip_status")
    Call<AcceptTripResult> driverAcceptTripStatus(
            @Field("driver_id") int driverId,
            @Field("customer_id") int customerId,
            @Field("customer_trip_id") int customerTripId,
            @Field("accept_status_id") int acceptStatusId
            //   @Field("helper_id") int helper
    );


    @FormUrlEncoded
    @POST("update_trip_status")
    Call<AcceptTripResult> driverStartCancelTripStatus(
            @Field("driver_id") int driverId,
            @Field("trip_status_id") int tripStatusId,
            @Field("customer_id") int customerId,
            @Field("customer_trip_id") int customerTripId,
            @Field("accept_status_id") int acceptStatusId
    );

    @Multipart
    @POST("/")
    Call<ResponseBody> postImage(
            @Part MultipartBody.Part image,
            @Field("driver_id") int driverId,
            @Part("name") RequestBody name
    );

    @Multipart
    @POST("upload_data")
    Call<PODResult> podDetails(
            @Part("driver_id") RequestBody driverId,
            @Part("customer_trip_id") RequestBody customerTripId,
            @Part("goods_type_image\";filename=\"goodsType.jpg\"") RequestBody goodsType,
            @Part("invoice_image\";filename=\"invoice.jpg\"") RequestBody invoice,
            @Part("signature_image\";filename=\"signature.jpg\"") RequestBody signature
    );

    @FormUrlEncoded
    @POST("driver_account")
    Call<AccountResult> accountDetails(
            @Field("driver_id") int deviceId,
            @Field("device_id") String deviceId1
    );

    @FormUrlEncoded
    @POST("driver_trip_details")
    Call<TripsResult> tripDetails(
            @Field("driver_id") int deviceId,
            @Field("device_id") String deviceId1
    );

    @FormUrlEncoded
    @POST("driver_earning_details")
    Call<EarningResult> earningDetails(
            @Field("driver_id") int driverId,
            @Field("device_id") String deviceId
    );

   *//*

    @FormUrlEncoded
    @POST("update/{id}")
    Call<Result> updateUser(
            @Path("id") int id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("gender") String gender
    );

    @FormUrlEncoded
    @POST("sendvisitscount/{id}")
    Call<Category> sendVisits(
            @Path("id") int id,
            @Field("visit") int visit
    );
*//*
*/
}
