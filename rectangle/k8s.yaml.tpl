apiVersion: apps/v1
kind: Deployment
metadata:
  name: rectangle-BRANCH_NAME
  labels:
    app: rectangle
    branch: BRANCH_NAME
spec:
  replicas: 1
  selector:
    matchLabels:
      app: rectangle
  template:
    metadata:
      labels:
        app: rectangle
    spec:
      containers:
        - name: rectangle
          image: gcr.io/GOOGLE_CLOUD_PROJECT/rectangle:COMMIT_SHA
          ports:
            - containerPort: 8080
          resources:
            requests:
              cpu: 100m
              memory: 128M
            limits:
              memory: 128M
          env:
            - name: CONTAINER_HOST
              valueFrom:
                fieldRef:
                  fieldPath: status.podIP
            - name: IMAGE_VERSION
              value: COMMIT_SHA
            - name: DE_NETWORKCHALLENGE_HOWTO_CANARY_FRONTEND_RECTANGLESERVICE_MP_REST_URL
              value: http://rectangle:8080
            - name: DE_NETWORKCHALLENGE_HOWTO_CANARY_FRONTEND_CIRCLESERVICE_MP_REST_URL
              value: http://circle:8080
---
kind: Service
apiVersion: v1
metadata:
  name: rectangle
spec:
  selector:
    app: rectangle
  ports:
    - protocol: TCP
      port: 8080
      targetPort: 8080
  type: ClusterIP