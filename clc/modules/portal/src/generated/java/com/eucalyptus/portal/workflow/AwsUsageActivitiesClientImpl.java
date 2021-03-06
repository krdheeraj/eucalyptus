/*
 * This code was generated by AWS Flow Framework Annotation Processor.
 * Refer to Amazon Simple Workflow Service documentation at http://aws.amazon.com/documentation/swf 
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
 package com.eucalyptus.portal.workflow;

import com.amazonaws.services.simpleworkflow.flow.ActivitiesClientBase;
import com.amazonaws.services.simpleworkflow.flow.ActivitySchedulingOptions;
import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericActivityClient;
import com.amazonaws.services.simpleworkflow.model.ActivityType;

public class AwsUsageActivitiesClientImpl extends ActivitiesClientBase implements AwsUsageActivitiesClient {

	public AwsUsageActivitiesClientImpl() {
        this(null, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }

    public AwsUsageActivitiesClientImpl(GenericActivityClient genericClient) {
        this(genericClient, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }
    
    public AwsUsageActivitiesClientImpl(GenericActivityClient genericClient, 
            DataConverter dataConverter, ActivitySchedulingOptions schedulingOptions) {
            
        super(genericClient, dataConverter, schedulingOptions);
    }
    
    @Override
    public final Promise<java.util.Map<java.lang.String,java.lang.String>> createAccountQueues(String globalQueue) {
        return createAccountQueuesImpl(Promise.asPromise(globalQueue), (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<java.util.Map<java.lang.String,java.lang.String>> createAccountQueues(String globalQueue, Promise<?>... waitFor) {
        return createAccountQueuesImpl(Promise.asPromise(globalQueue), (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<java.util.Map<java.lang.String,java.lang.String>> createAccountQueues(String globalQueue, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return createAccountQueuesImpl(Promise.asPromise(globalQueue), optionsOverride, waitFor);
    }

    @Override
    public final Promise<java.util.Map<java.lang.String,java.lang.String>> createAccountQueues(Promise<String> globalQueue) {
        return createAccountQueuesImpl(globalQueue, (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<java.util.Map<java.lang.String,java.lang.String>> createAccountQueues(Promise<String> globalQueue, Promise<?>... waitFor) {
        return createAccountQueuesImpl(globalQueue, (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<java.util.Map<java.lang.String,java.lang.String>> createAccountQueues(Promise<String> globalQueue, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return createAccountQueuesImpl(globalQueue, optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<java.util.Map<java.lang.String,java.lang.String>> createAccountQueuesImpl(final Promise<String> globalQueue, final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.createAccountQueues");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[1];
        _input_[0] = globalQueue;

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, java.util.Map.class, waitFor);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportHourlyUsageRecord(String accountId, String queueName) {
        return getAwsReportHourlyUsageRecordImpl(Promise.asPromise(accountId), Promise.asPromise(queueName), (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportHourlyUsageRecord(String accountId, String queueName, Promise<?>... waitFor) {
        return getAwsReportHourlyUsageRecordImpl(Promise.asPromise(accountId), Promise.asPromise(queueName), (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportHourlyUsageRecord(String accountId, String queueName, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return getAwsReportHourlyUsageRecordImpl(Promise.asPromise(accountId), Promise.asPromise(queueName), optionsOverride, waitFor);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportHourlyUsageRecord(Promise<String> accountId, Promise<String> queueName) {
        return getAwsReportHourlyUsageRecordImpl(accountId, queueName, (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportHourlyUsageRecord(Promise<String> accountId, Promise<String> queueName, Promise<?>... waitFor) {
        return getAwsReportHourlyUsageRecordImpl(accountId, queueName, (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportHourlyUsageRecord(Promise<String> accountId, Promise<String> queueName, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return getAwsReportHourlyUsageRecordImpl(accountId, queueName, optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportHourlyUsageRecordImpl(final Promise<String> accountId, final Promise<String> queueName, final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.getAwsReportHourlyUsageRecord");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[2];
        _input_[0] = accountId;
        _input_[1] = queueName;

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, java.util.List.class, waitFor);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportDailyUsageRecord(String accountId, String queueName) {
        return getAwsReportDailyUsageRecordImpl(Promise.asPromise(accountId), Promise.asPromise(queueName), (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportDailyUsageRecord(String accountId, String queueName, Promise<?>... waitFor) {
        return getAwsReportDailyUsageRecordImpl(Promise.asPromise(accountId), Promise.asPromise(queueName), (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportDailyUsageRecord(String accountId, String queueName, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return getAwsReportDailyUsageRecordImpl(Promise.asPromise(accountId), Promise.asPromise(queueName), optionsOverride, waitFor);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportDailyUsageRecord(Promise<String> accountId, Promise<String> queueName) {
        return getAwsReportDailyUsageRecordImpl(accountId, queueName, (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportDailyUsageRecord(Promise<String> accountId, Promise<String> queueName, Promise<?>... waitFor) {
        return getAwsReportDailyUsageRecordImpl(accountId, queueName, (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportDailyUsageRecord(Promise<String> accountId, Promise<String> queueName, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return getAwsReportDailyUsageRecordImpl(accountId, queueName, optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> getAwsReportDailyUsageRecordImpl(final Promise<String> accountId, final Promise<String> queueName, final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.getAwsReportDailyUsageRecord");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[2];
        _input_[0] = accountId;
        _input_[1] = queueName;

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, java.util.List.class, waitFor);
    }

    @Override
    public final Promise<Void> writeAwsReportUsage(java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord> records) {
        return writeAwsReportUsageImpl(Promise.asPromise(records), (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> writeAwsReportUsage(java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord> records, Promise<?>... waitFor) {
        return writeAwsReportUsageImpl(Promise.asPromise(records), (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> writeAwsReportUsage(java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord> records, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return writeAwsReportUsageImpl(Promise.asPromise(records), optionsOverride, waitFor);
    }

    @Override
    public final Promise<Void> writeAwsReportUsage(Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> records) {
        return writeAwsReportUsageImpl(records, (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> writeAwsReportUsage(Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> records, Promise<?>... waitFor) {
        return writeAwsReportUsageImpl(records, (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> writeAwsReportUsage(Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> records, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return writeAwsReportUsageImpl(records, optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> writeAwsReportUsageImpl(final Promise<java.util.List<com.eucalyptus.portal.workflow.AwsUsageRecord>> records, final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.writeAwsReportUsage");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[1];
        _input_[0] = records;

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, Void.class, waitFor);
    }

    @Override
    public final Promise<Void> deleteAccountQueues(java.util.List<java.lang.String> queues) {
        return deleteAccountQueuesImpl(Promise.asPromise(queues), (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> deleteAccountQueues(java.util.List<java.lang.String> queues, Promise<?>... waitFor) {
        return deleteAccountQueuesImpl(Promise.asPromise(queues), (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> deleteAccountQueues(java.util.List<java.lang.String> queues, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return deleteAccountQueuesImpl(Promise.asPromise(queues), optionsOverride, waitFor);
    }

    @Override
    public final Promise<Void> deleteAccountQueues(Promise<java.util.List<java.lang.String>> queues) {
        return deleteAccountQueuesImpl(queues, (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> deleteAccountQueues(Promise<java.util.List<java.lang.String>> queues, Promise<?>... waitFor) {
        return deleteAccountQueuesImpl(queues, (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> deleteAccountQueues(Promise<java.util.List<java.lang.String>> queues, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return deleteAccountQueuesImpl(queues, optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> deleteAccountQueuesImpl(final Promise<java.util.List<java.lang.String>> queues, final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.deleteAccountQueues");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[1];
        _input_[0] = queues;

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, Void.class, waitFor);
    }

    @Override
    public final Promise<Void> cleanupQueues() {
        return cleanupQueuesImpl((ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> cleanupQueues(Promise<?>... waitFor) {
        return cleanupQueuesImpl((ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> cleanupQueues(ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return cleanupQueuesImpl(optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> cleanupQueuesImpl(final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.cleanupQueues");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[0];

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, Void.class, waitFor);
    }

    @Override
    public final Promise<Void> fireVolumeUsage() {
        return fireVolumeUsageImpl((ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> fireVolumeUsage(Promise<?>... waitFor) {
        return fireVolumeUsageImpl((ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> fireVolumeUsage(ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return fireVolumeUsageImpl(optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> fireVolumeUsageImpl(final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.fireVolumeUsage");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[0];

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, Void.class, waitFor);
    }

    @Override
    public final Promise<Void> fireSnapshotUsage() {
        return fireSnapshotUsageImpl((ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> fireSnapshotUsage(Promise<?>... waitFor) {
        return fireSnapshotUsageImpl((ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> fireSnapshotUsage(ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return fireSnapshotUsageImpl(optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> fireSnapshotUsageImpl(final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.fireSnapshotUsage");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[0];

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, Void.class, waitFor);
    }

    @Override
    public final Promise<Void> fireAddressUsage() {
        return fireAddressUsageImpl((ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> fireAddressUsage(Promise<?>... waitFor) {
        return fireAddressUsageImpl((ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> fireAddressUsage(ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return fireAddressUsageImpl(optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> fireAddressUsageImpl(final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.fireAddressUsage");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[0];

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, Void.class, waitFor);
    }

    @Override
    public final Promise<Void> fireS3ObjectUsage() {
        return fireS3ObjectUsageImpl((ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> fireS3ObjectUsage(Promise<?>... waitFor) {
        return fireS3ObjectUsageImpl((ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> fireS3ObjectUsage(ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return fireS3ObjectUsageImpl(optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> fireS3ObjectUsageImpl(final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.fireS3ObjectUsage");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[0];

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, Void.class, waitFor);
    }

    @Override
    public final Promise<Void> fireLoadBalancerUsage() {
        return fireLoadBalancerUsageImpl((ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> fireLoadBalancerUsage(Promise<?>... waitFor) {
        return fireLoadBalancerUsageImpl((ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> fireLoadBalancerUsage(ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return fireLoadBalancerUsageImpl(optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> fireLoadBalancerUsageImpl(final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType _activityType = new ActivityType();
		_activityType.setName("AwsUsageActivities.fireLoadBalancerUsage");
		_activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[0];

        return (Promise)scheduleActivity(_activityType, _input_, optionsOverride, Void.class, waitFor);
    }

}